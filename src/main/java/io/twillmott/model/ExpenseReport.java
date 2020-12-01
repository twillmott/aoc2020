package io.twillmott.model;

import lombok.Data;

import java.util.List;

@Data
public class ExpenseReport {
    private final List<Integer> entries;
}
