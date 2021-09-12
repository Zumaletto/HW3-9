package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();
    Radio radio1 = new Radio(15, 14);

    @ParameterizedTest
    @CsvSource(
            value = {"-1, 0",
                    "0, 0",
                    "5, 5",
                    "10, 0",
                    "9, 9"
            }
    )
    void shouldSetAndGetCurrentRadioWave(int currentRadioWave, int expected) {
        radio.setCurrentRadioWave(currentRadioWave);
        assertEquals(expected, radio.getCurrentRadioWave());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"-1, 0",
                    "0, 0",
                    "5, 5",
                    "15, 0",
                    "14, 14"
            }
    )
    void shouldSetAndGetCurrentRadioWave1(int currentRadioWave, int expected) {
        radio1.setCurrentRadioWave(currentRadioWave);
        assertEquals(expected, radio1.getCurrentRadioWave());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"4, 5",
                    "9, 0"
            }
    )
    void shouldPressNext(int currentRadioWave, int expected) {
        radio.setCurrentRadioWave(currentRadioWave);
        radio.next();
        assertEquals(expected, radio.getCurrentRadioWave());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"4, 5",
                    "14, 0"
            }
    )
    void shouldPressNext1(int currentRadioWave, int expected) {
        radio1.setCurrentRadioWave(currentRadioWave);
        radio1.next();
        assertEquals(expected, radio1.getCurrentRadioWave());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"0, 9",
                    "4, 3"
            }
    )
    void shouldPressPrev(int currentRadioWave, int expected) {
        radio.setCurrentRadioWave(currentRadioWave);
        radio.prev();
        assertEquals(expected, radio.getCurrentRadioWave());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"-1, 0",
                    "0, 0",
                    "5, 5",
                    "110, 0",
                    "100, 100"}
    )
    void shouldSetAndGetCurrentSoundValue(int currentSoundValue, int expected) {
        radio.setCurrentSoundValue(currentSoundValue);
        assertEquals(expected, radio.getCurrentSoundValue());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"100,99",
                    "0, 0",
                    "5, 4"}
    )
    public void shouldSwitchCurrentSoundValue(int currentSoundValue, int expected) {
        radio.setCurrentSoundValue(currentSoundValue);
        radio.minus();
        assertEquals(expected, radio.getCurrentSoundValue());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"100, 100",
                    "5, 6",
                    "0, 1"
            }
    )
    public void shouldSwitchCurrentSoundMaxValue(int currentSoundValue, int expected) {
        radio.setCurrentSoundValue(currentSoundValue);
        radio.plus();
        assertEquals(expected, radio.getCurrentSoundValue());
    }
}