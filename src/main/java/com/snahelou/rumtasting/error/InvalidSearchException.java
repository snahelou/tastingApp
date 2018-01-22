package com.snahelou.rumtasting.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
@Getter
@Setter
public class InvalidSearchException extends RuntimeException {

    public InvalidSearchException(String s){
        super(s);
    }
}
