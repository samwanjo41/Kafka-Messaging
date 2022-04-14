package com.example.consumer.service;

import com.example.consumer.model.FoodOrder;
import com.example.consumer.model.FoodOrderDto;
import com.example.consumer.repository.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;
    private final ModelMapper modelMapper;

    public FoodOrderService(FoodOrderRepository foodOrderRepository, ModelMapper modelMapper) {
        this.foodOrderRepository = foodOrderRepository;
        this.modelMapper = modelMapper;
    }

    public void persistFoodOrder(FoodOrderDto foodOrderDto) {

        FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
        FoodOrder peristedFoodOrder = foodOrderRepository.save(foodOrder);

        log.info("food order persisted {}", peristedFoodOrder);
    }
}
