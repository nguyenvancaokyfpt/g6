package com.tss.service;

import com.tss.model.Client;

public interface ClientService {
    
    Client findClientById(int userId);
    String update(int userId,String address, String company);
    
}
