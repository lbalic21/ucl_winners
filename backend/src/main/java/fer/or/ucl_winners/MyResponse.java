package fer.or.ucl_winners;

import java.io.Serializable;
import java.util.List;


import fer.or.ucl_winners.model.UclWinner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyResponse implements Serializable {
    private String status;
    private String message;  
    private List<UclWinner> response;
}
