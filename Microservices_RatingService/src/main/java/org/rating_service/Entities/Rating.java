package org.rating_service.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings") // Mongodb mai entity bnane ke liye yala notation use hota h, to make these variables as columns...
public class Rating {
    @Id // ye id auto generate ho jaayegi mongodb mai...
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
