package fr.lernejo;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
class SampleTest {

    @org.junit.jupiter.api.Test
    void operation_by_int_should_produce() {
        Sample object = new Sample();
        int x = object.op(Sample.Operation.ADD, 5, 6);
        int y = object.op(Sample.Operation.MULT, 5, 6);
        Assertions.assertThat(x).as("5 + 6 = ").isEqualTo(11);
        Assertions.assertThat(y).as("5 * 6 = ").isEqualTo(30);
    }


    @org.junit.jupiter.api.Test
    void fact_by_negative_int_should_produce_an_exception() {
        Sample object = new Sample();
        //int t = object.fact(-3);
        //Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(t)
        assertThrows(IllegalArgumentException.class, () -> {
            object.fact(-3);
        });
    }

    @org.junit.jupiter.api.Test
    void fact_by_int_should_produce() {
        Sample object = new Sample();
        int j = object.fact(3);
        Assertions.assertThat(j).as("fact(3) = ").isEqualTo(6);
    }
}


