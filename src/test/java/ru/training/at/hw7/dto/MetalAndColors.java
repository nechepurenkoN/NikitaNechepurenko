package ru.training.at.hw7.dto;

import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetalAndColors extends DataClass<MetalAndColors> {
    @JsonProperty("summary")
    List<Integer> summary;
    @JsonProperty("elements")
    List<String> elements;
    @JsonProperty("color")
    String colors;
    @JsonProperty("metals")
    String metals;
    @JsonProperty("vegetables")
    List<String> vegetables;

    public String getOdd() {
        return summary.get(0).toString();
    }

    public String getEven() {
        return summary.get(1).toString();
    }

    public String toResultString() {
        return String.format("Summary: %s\nElements: %s\nColor: %s\nMetal: %s\nVegetables: %s",
            summary.stream().mapToInt(Integer::intValue).sum(),
            String.join(", ", elements),
            colors,
            metals,
            String.join(", ", vegetables)
        );
    }
}
