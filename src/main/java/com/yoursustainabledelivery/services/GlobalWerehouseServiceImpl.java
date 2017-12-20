package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.GlobalWerehouseDao;
import com.yoursustainabledelivery.model.GlobalWerehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "GlobalWerehouseService")
@Transactional
public class GlobalWerehouseServiceImpl implements GlobalWerehouseService {

   @Autowired
    GlobalWerehouseDao globalWerehouseDao;



}
