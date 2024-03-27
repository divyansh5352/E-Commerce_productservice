package com.scaler.productservice.Servies;

import com.scaler.productservice.DTO.addProductDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Category;
import com.scaler.productservice.Models.Product;
import com.scaler.productservice.Repository.CategoryRepository;
import com.scaler.productservice.Repository.ElasticsearchProductRepository;
import com.scaler.productservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//Here we are giving name to Bean of SelfProductService inside the annotation
@Service("SelfProductService")
@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;
    private ElasticsearchProductRepository elasticsearchProductRepository;
    @Autowired
    public SelfProductService( ElasticsearchProductRepository elasticsearchProductRepository, ProductRepository productRepository, CategoryRepository categoryRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.elasticsearchProductRepository = elasticsearchProductRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        //Optional<Product> productOptional = productRepository.findById(id);
        Optional<Product> productOptional = elasticsearchProductRepository.findById(id);
        if ( productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with ID "+id+" doesn't exists.");
        }
        return productOptional.get();
    }
    @Override
    public ArrayList<Product> getAllProducts() {

        //changes for paging
        // change return type to Page<Products>
        // change function to
        // getAllProducts(int pageNumber ,
        //                int pageSize ,
        //                String sortBy ,
        //                String sortOrder)
        // take int pageNumber and int pageSize String sortBy,String sortOrder
        // as input in method from user
        //first sort by price and then is price is ame than sort on name
        //Sort sort = Sort.by("price").descending().and(Sort.by("name").ascending());
        //productRepository.findAll(PageRequest.of(pageNumber, pageSize , sort);

        return (ArrayList<Product>) productRepository.findAll();
    }
    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        return updateProduct(id,product);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);

        if ( productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: "+id+" does,t exists.");
        }

        Product savedProduct = productOptional.get();
        if (product.getCategory() != null ){
            savedProduct.setCategory(product.getCategory());
        }
        if ( product.getDescription() != null ){
            savedProduct.setDescription(product.getDescription());
        }
        if ( product.getTitle() != null ){
            savedProduct.setTitle(product.getTitle());
        }

        if ( product.getPrice() != null ){
            savedProduct.setPrice(product.getPrice());
        }
        if ( product.getImageURL() != null ){
            savedProduct.setImageURL(product.getImageURL());
        }
        return productRepository.save(savedProduct);
    }

    @Override
    public Product addNewProduct(addProductDTO productDTO) {
        Optional<Category> categoryOptional = categoryRepository.findByName(productDTO.getCategoryName());

        Product addProduct = new Product();
        addProduct.setTitle(productDTO.getTitle());
        addProduct.setPrice(productDTO.getPrice());
        addProduct.setDescription(productDTO.getDescription());
        addProduct.setImageURL(productDTO.getImageURL());

        if ( categoryOptional.isEmpty() ){
            /*
            we don't need this if logic because we have used CascadeType.ALL,
            so it will automatically create a category if it does not exist
             */
            //product.setCategory(categoryRepository.save(product.getCategory()));


            addProduct.setCategory(categoryService.addCategory(productDTO.getCategoryName()));
        }
        else
        {
            addProduct.setCategory(categoryOptional.get());
        }


        return productRepository.save(addProduct);
    }

    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if ( productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id :"+id+"doesn't exists");
        }
        else {
            productRepository.deleteById(id);
            return true;
        }
    }
}
