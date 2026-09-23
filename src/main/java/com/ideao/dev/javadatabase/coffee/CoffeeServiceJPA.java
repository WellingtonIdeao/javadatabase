package com.ideao.dev.javadatabase.coffee;

import com.ideao.dev.javadatabase.coffee.dtos.CreateCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.UpdateCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.CoffeeDTO;
import com.ideao.dev.javadatabase.coffee.exceptions.CoffeeNotFoundException;
import com.ideao.dev.javadatabase.coffee.mappers.CoffeeMapper;
import com.ideao.dev.javadatabase.common.database.TransactionManager;
import com.ideao.dev.javadatabase.supplier.Supplier;
import com.ideao.dev.javadatabase.supplier.SupplierDaoJPA;
import com.ideao.dev.javadatabase.supplier.exceptions.SupplierNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoffeeServiceJPA {
    private final CoffeeDaoJPA coffeeRepository;
    private final SupplierDaoJPA supplierRepository;

    public CoffeeServiceJPA() {
        this.coffeeRepository =  new CoffeeDaoJPA();
        this.supplierRepository = new SupplierDaoJPA();
    }

    public List<CoffeeDTO> list() {
        return TransactionManager.execute(em -> {
            List<CoffeeDTO> dtos = new ArrayList<>();
            List<Coffee> coffees = coffeeRepository.list();
            for (Coffee coffee : coffees) {
                dtos.add(CoffeeMapper.toDTO(coffee));
            }
            return dtos;
        });
    }

    public void create(CreateCoffeeDTO coffeeDTO) {
        TransactionManager.execute(em -> {

            Optional<Supplier> optSupplier = supplierRepository.findById(coffeeDTO.getSupplierId());
            Supplier supplier = optSupplier.orElseThrow(() -> new SupplierNotFoundException("Supplier not found."));
            Coffee coffee = CoffeeMapper.toEntity(coffeeDTO);
            coffee.addSupplier(supplier);
            coffee.setActive(true);
            coffeeRepository.create(coffee);
        });
    }

    public CoffeeDTO findById(Long id) {
       return TransactionManager.execute(em -> {
           if (id == null) {
               throw new IllegalArgumentException("O ID fornecido não pode ser nulo.");
           }
           Optional<Coffee> optCoffee = coffeeRepository.findById(id);
           Coffee coffee =
                   optCoffee.orElseThrow(
                           () -> new CoffeeNotFoundException("Coffee not found for id = " + id + ". Try again!"));
           return CoffeeMapper.toDTO(coffee);
       });
    }

    public void update(UpdateCoffeeDTO coffeeDTO) {
        TransactionManager.execute(em -> {
            Optional<Coffee> optCoffee = coffeeRepository.findById(coffeeDTO.getId());
            Coffee coffee =
                    optCoffee.orElseThrow(
                            () -> new CoffeeNotFoundException("Coffee not found for id = " + coffeeDTO.getId() + "."));
            CoffeeMapper.updateEntityFromDTO(coffeeDTO, coffee);
            coffee.setActive(true);
        });
    }

    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID fornecido não pode ser nulo.");
        }
        TransactionManager.execute(em -> {
            Optional<Coffee> optCoffee = coffeeRepository.findById(id);
            Coffee coffee =
                    optCoffee.orElseThrow(
                            () -> new CoffeeNotFoundException("Coffee not found for id = " + id + "."));
            em.remove(coffee);
        });
    }
}