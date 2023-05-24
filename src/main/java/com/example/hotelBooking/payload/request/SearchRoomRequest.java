package com.example.hotelBooking.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRoomRequest {
    @NotBlank
    private int adultsMax;
    @NotBlank
    private int childrenMax;
    @NotBlank
    private Date startDate;
    @NotBlank
    private Date endDate;
}
