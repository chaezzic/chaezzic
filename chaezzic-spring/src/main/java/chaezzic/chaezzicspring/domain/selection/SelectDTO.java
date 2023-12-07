package chaezzic.chaezzicspring.domain.selection;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectDTO {
    private String year;
    private String part;
    private String job;
}
