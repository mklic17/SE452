package group3.com.example.retail.product;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
	
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        return productForm;
    }

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.constructType(Product.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.constructType(ProductForm.class);

	}

}


