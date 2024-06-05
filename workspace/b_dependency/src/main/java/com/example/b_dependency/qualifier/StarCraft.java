package com.example.b_dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StarCraft implements Game {

    @Override
    public void play() {
        log.info("Playing StarCraft");
    }
}
