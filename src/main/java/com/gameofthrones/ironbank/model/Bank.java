package com.gameofthrones.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;

/**
 * @author Evgeny Borisov
 */
@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    private String id;
    private String name;
    private long balance;


}
