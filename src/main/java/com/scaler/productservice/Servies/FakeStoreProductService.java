package com.scaler.productservice.Servies;

import com.scaler.productservice.DTO.FakeStoreProductDTO;
import com.scaler.productservice.DTO.addProductDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Category;
import com.scaler.productservice.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service("FakeStoreProductService")
//@Primary
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate , RedisTemplate<String ,Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Product p = (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+id);

        if ( p != null ){
            return p;
        }
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/"+id ,
                FakeStoreProductDTO.class);

        if ( fakeStoreProductDTO == null ){
            throw new ProductNotFoundException("Product with id "+id+" doesn't exists");
        }

        Product p1 = convertFakeStoreProductToProduct(fakeStoreProductDTO);
        redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_"+id , p1);
        Product prc = (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+id);

        return p1;
    }


    @Override
    public ArrayList<Product> getAllProducts() {

        /*
            we cannot use
            ArrayList<FakeStoreProductDTO> response = restTemplate.getForObject
                                                   ("https://fakestoreapi.com/products" ,
                                                    ArrayList<FakeStoreProductDTO>.class );
             because of generics
             java only see it as list of something , and not list of FakeStoreProductDTO,
             and it converts Json file to hashMap (key value pair ) ,
             so it becomes ArrayList<HashMap()>.class

             but we are storing it in ArrayList of FakeStoreProductDTO ,
             so it will give compile time errors.

             we can solve it by using array instead of arraylist
             because arrays are not generic like arraylist
         */
        FakeStoreProductDTO[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products" ,
                        FakeStoreProductDTO[].class );

        ArrayList<Product>ans = new ArrayList<>();
        for ( FakeStoreProductDTO fakeStoreProductDTO : response )
        {
            ans.add(convertFakeStoreProductToProduct(fakeStoreProductDTO));
        }
        return ans;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setImage(product.getImageURL());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                                    new HttpMessageConverterExtractor(FakeStoreProductDTO.class,
                                                                    restTemplate.getMessageConverters());
        FakeStoreProductDTO response=  restTemplate.execute("https://fakestoreapi.com/products/"+id,
                                    HttpMethod.PUT, requestCallback,
                                    responseExtractor );

        return convertFakeStoreProductToProduct(response);

//        RequestCallback requestCallback = this.httpEntityCallback(request, responseType);
//        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, this.getMessageConverters(), this.logger);
//        return this.execute(url, HttpMethod.POST, requestCallback, responseExtractor, (Object[])uriVariables);



    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(addProductDTO product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product p = new Product();
        p.setTitle(fakeStoreProductDTO.getTitle());
        p.setId(fakeStoreProductDTO.getId());
        p.setPrice(fakeStoreProductDTO.getPrice());
        p.setDescription(fakeStoreProductDTO.getDescription());
        p.setImageURL(fakeStoreProductDTO.getImage());
        p.setCategory(new Category());
        p.getCategory().setName(fakeStoreProductDTO.getCategory());

        return p;
    }
}
