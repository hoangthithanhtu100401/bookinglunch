package com.hivetech.bookinglunch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Sets sets;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
