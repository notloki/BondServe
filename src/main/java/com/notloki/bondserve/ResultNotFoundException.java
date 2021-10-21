package com.notloki.bondserve;

class ResultNotFoundException extends RuntimeException {
    ResultNotFoundException(Long id) {
        super("Result not found: " + id);
    }
}

class PersonNotFoundException extends RuntimeException {
    PersonNotFoundException(Long id) { super("Person not found: " + id);  }
}
