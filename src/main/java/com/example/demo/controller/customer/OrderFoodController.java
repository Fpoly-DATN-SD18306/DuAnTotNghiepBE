package com.example.demo.controller.customer;

import com.example.demo.entity.TableEntity;
import com.example.demo.enums.OrderStatus;
import com.example.demo.enums.TableStatus;
import com.example.demo.repository.TableRepository;
import com.example.demo.request.FoodRequestOrderDTO;
import com.example.demo.respone.ApiRespone;
import com.example.demo.respone.OrderResponeDTO;
import com.example.demo.service.OrderService;
import com.example.demo.service.TableService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/order")

public class OrderFoodController {

    @Autowired
    OrderService orderService;
    @Autowired
    TableRepository tableRepository;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    // @MessageMapping
    // @SendTo("/topic/postorder")
    @PostMapping
    public ApiRespone<?> postOrder(@RequestBody List<FoodRequestOrderDTO> listFoodOrder,
            @RequestParam Integer idTable, @RequestParam String ipCustomer,
            @RequestParam(required = false) String numberPhone) {
        var result = orderService.saveOrder(listFoodOrder, idTable, numberPhone, ipCustomer, OrderStatus.Waiting);
        messagingTemplate.convertAndSend("/topic/postorder", result);
        System.out.println(listFoodOrder.toString());
        System.out.println("id table :" + idTable);
        return ApiRespone.builder()
                .result(result)
                .build();
    }

    @GetMapping("{idTable}")
    public ApiRespone<?> callStaff(@PathVariable("idTable") Integer idTable) {
        TableEntity table = tableRepository.findById(idTable).get();
        messagingTemplate.convertAndSend("/topic/callStaff", table);
        return ApiRespone.builder().result(table).build();
    }
}