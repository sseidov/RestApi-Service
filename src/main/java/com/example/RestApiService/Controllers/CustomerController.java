package com.example.RestApiService.Controllers;

import com.example.RestApiService.Entities.Customer;
import com.example.RestApiService.Exceptions.CustomerAlreadyExistException;
import com.example.RestApiService.Exceptions.CustomerNotFoundException;
import com.example.RestApiService.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity registrationNewUser(@RequestBody Customer customer){
        try{
            customerService.registrationNewCustomer(customer);
            return ResponseEntity.ok("Пользователь был успешно сохранен");
        } catch (CustomerAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка создания клиента, проверьте были ли заполнены все необходимые поля.");
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateChosenUser(@PathVariable Long id,
                                           @RequestBody Customer changedCustomer){
        try {
            customerService.updateUser(id, changedCustomer);
            return ResponseEntity.ok("Пользователь был успешно редактирован!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка изменения данных о клиенте");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(customerService.getOneUser(id));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка вывода данных о клиенте");
        }
    }

    @GetMapping("/get")
    public ResponseEntity getUserByName(@RequestParam String username) {
        try {
            return ResponseEntity.ok(customerService.getUserByUsername(username));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка вывода данных о клиенте");
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(customerService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка удаления клиента");
        }
    }

}
