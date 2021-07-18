package ru.training.at.hw7.page.objects;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.elements.composite.WebPage;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import ru.training.at.hw7.dto.MetalAndColors;
import ru.training.at.hw7.page.elements.MetalAndColorsForm;
import ru.training.at.hw7.page.elements.ResultBlock;
import ru.training.at.hw7.page.objects.MetalAndColorsPage.MetalAndColorsPageAssert;

public class MetalAndColorsPage extends WebPage implements HasAssert<MetalAndColorsPageAssert> {
    public static MetalAndColorsForm form;
    public static ResultBlock result;

    public void submit(MetalAndColors value) {
        form.fill(value);
        form.submit();
    }

    @Override
    public MetalAndColorsPageAssert is() {
        return new MetalAndColorsPageAssert();
    }

    @Override
    public MetalAndColorsPageAssert assertThat() {
        return HasAssert.super.assertThat();
    }

    @Override
    public MetalAndColorsPageAssert has() {
        return HasAssert.super.has();
    }

    @Override
    public MetalAndColorsPageAssert waitFor() {
        return HasAssert.super.waitFor();
    }

    @Override
    public MetalAndColorsPageAssert waitFor(int sec) {
        return HasAssert.super.waitFor(sec);
    }

    @Override
    public MetalAndColorsPageAssert shouldBe() {
        return HasAssert.super.shouldBe();
    }

    @Override
    public MetalAndColorsPageAssert verify() {
        return HasAssert.super.verify();
    }

    public static class MetalAndColorsPageAssert {
        public void resultIsMatch(MetalAndColors value) {
            Assertions.assertThat(String.join("\n", result.getLines())).isEqualTo(value.toResultString());
        }
    }
}
