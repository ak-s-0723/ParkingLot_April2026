package org.example.parking_lot_april2026.models;

import java.util.Date;

public abstract class BaseModel {
    private Long id;

    //For Investigation in case of anomalies
    private Date createdAt;
    private Date lastUpdatedAt;

}
