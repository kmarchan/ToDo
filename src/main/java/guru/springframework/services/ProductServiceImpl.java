package guru.springframework.services;

import guru.springframework.domain.DomainObject;
import guru.springframework.domain.ToDo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jt on 11/6/15.
 */
@Service
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public ToDo getById(Integer id) {
        return (ToDo) super.getById(id);
    }

    @Override
    public ToDo saveOrUpdate(ToDo domainObject) {
        return (ToDo) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        ToDo product1 = new ToDo();
        product1.setId(1);
        product1.setDescription("todo 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        domainMap.put(1, product1);

        ToDo product2 = new ToDo();
        product2.setId(2);
        product2.setDescription("todo 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        domainMap.put(2, product2);

        ToDo product3 = new ToDo();
        product3.setId(3);
        product3.setDescription("todo 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        domainMap.put(3, product3);

        ToDo product4 = new ToDo();
        product4.setId(4);
        product4.setDescription("todo 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        domainMap.put(4, product4);

        ToDo product5 = new ToDo();
        product5.setId(5);
        product5.setDescription("todo 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        domainMap.put(5, product5);
    }
}