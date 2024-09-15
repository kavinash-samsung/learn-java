package com.avinash;

import java.util.Collection;

public interface Analyzer {
    public Collection<String> terms(String text);
}
