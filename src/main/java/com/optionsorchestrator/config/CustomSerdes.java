package com.optionsorchestrator.config;

import com.optionsorchestrator.model.OptionEvent;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonSerializer;

public final class CustomSerdes {
    static public final class OptionEventsSerde
            extends Serdes.WrapperSerde<OptionEvent> {
        public OptionEventsSerde() {
            super(new JsonSerializer<>(),
                    new PayloadDeserializer<>(OptionEvent.class));
        }
    }

    public static Serde<OptionEvent> OptionEvent() {
        return new CustomSerdes.OptionEventsSerde();
    }
}