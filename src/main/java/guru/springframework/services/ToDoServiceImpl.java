package guru.springframework.services;

import guru.springframework.domain.DomainObject;
import guru.springframework.domain.ToDo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ToDoServiceImpl extends AbstractMapService implements ToDoService {

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

        ToDo todo1 = new ToDo();
        todo1.setId(1);
        todo1.setDescription("todo 1");
        todo1.setImageUrl("http://example.com/todo1");

        domainMap.put(1, todo1);

        ToDo todo2 = new ToDo();
        todo2.setId(2);
        todo2.setDescription("todo 2");
        todo2.setImageUrl("http://example.com/todo2");

        domainMap.put(2, todo2);

        ToDo todo3 = new ToDo();
        todo3.setId(3);
        todo3.setDescription("todo 3");
        todo3.setImageUrl("http://example.com/todo3");

        domainMap.put(3, todo3);

        ToDo todo4 = new ToDo();
        todo4.setId(4);
        todo4.setDescription("todo 4");
        todo4.setImageUrl("http://example.com/todo4");

        domainMap.put(4, todo4);

        ToDo todo5 = new ToDo();
        todo5.setId(5);
        todo5.setDescription("todo 25");
        todo5.setImageUrl("http://example.com/todo5");

        domainMap.put(5, todo5);
    }
}