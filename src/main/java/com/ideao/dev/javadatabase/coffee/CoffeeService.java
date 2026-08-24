package com.ideao.dev.javadatabase.coffee;

import com.ideao.dev.javadatabase.common.database.DAOFactory;
import com.ideao.dev.javadatabase.common.repository.GenericRepository;
import com.ideao.dev.javadatabase.coffee.dto.AddCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dto.CoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dto.UpdateCoffeeDTO;
import com.ideao.dev.javadatabase.supplier.Supplier;

import java.util.ArrayList;
import java.util.List;

public class CoffeeService {
    private final GenericRepository<Coffee, String> coffeeRepository;
    private final GenericRepository<Supplier, Long> supplierRepository;

    public CoffeeService() {
        this.coffeeRepository = DAOFactory.createCoffeeDAO();
        this.supplierRepository = DAOFactory.createSupplierDAO();

    }

    public List<CoffeeDTO> viewList() {
        List<Coffee> coffees = coffeeRepository.viewList();
        List<CoffeeDTO> coffeeDTOS = new ArrayList<>();
        for (Coffee c : coffees) {
           coffeeDTOS.add(new CoffeeDTO(c));
        }
        return coffeeDTOS;
    }

    public void add(AddCoffeeDTO coffeeDTO) {

        Boolean existsSupplier = supplierRepository.existsById(coffeeDTO.getSupId());

        if (existsSupplier) {
            Coffee coffee =
                    new Coffee(
                            coffeeDTO.getName(), coffeeDTO.getSupId(),
                            coffeeDTO.getPrice(), coffeeDTO.getSales(), coffeeDTO.getTotal()
                    );
           coffeeRepository.create(coffee);
        } else {
            System.out.println("Coffee with invalid Supplier.");
        }
    }

    public CoffeeDTO read(String id) {
        Coffee coffee = coffeeRepository.read(id);
        CoffeeDTO coffeeDTO = null;
        if(coffee != null) {
            coffeeDTO = new CoffeeDTO(coffee);
        }
        return coffeeDTO;
    }

    public void delete(String id) {
        if(coffeeRepository.existsById(id)) {
            coffeeRepository.delete(id);
        }
    }

    public void update(UpdateCoffeeDTO coffeeDTO) {
        Coffee coffee =
                new Coffee(
                        coffeeDTO.getName(), coffeeDTO.getSupId(), coffeeDTO.getPrice(),
                        coffeeDTO.getSales(), coffeeDTO.getTotal()
                );
       boolean existsCoffee =  coffeeRepository.existsById(coffee.getName());
       boolean existsSupplier = supplierRepository.existsById(coffee.getSupId());

       if (existsCoffee && existsSupplier) {
           coffeeRepository.update(coffee);
       } else {
           System.out.println("Coffee invalid.");
       }
    }
}
