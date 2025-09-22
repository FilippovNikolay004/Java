package app;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private long id;
    private String customerName;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private List<String> items;
}
