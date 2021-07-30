package org.zerock.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StoreDTO {
    private String name;
    private double lat,lng;
    private String menu;
    private double score;

}
