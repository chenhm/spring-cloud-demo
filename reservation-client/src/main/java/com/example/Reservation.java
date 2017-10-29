package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Client-side DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
class Reservation {
    private Long Id;
    private String reservationName;
}
