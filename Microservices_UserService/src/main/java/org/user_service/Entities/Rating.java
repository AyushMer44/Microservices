package org.user_service.Entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String feedback;

    private Hotel hotel;
}
