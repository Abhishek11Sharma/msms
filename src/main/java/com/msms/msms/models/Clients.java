package com.msms.msms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients extends DateAudit {
    
    private Integer id;
    private String clientId;
    private String clientName;
}
