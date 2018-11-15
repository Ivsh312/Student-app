package by.liba.student.webservlet.readers;

import by.liba.student.common.Groups;
import by.liba.student.common.Students;

public interface LineMapper<T> {
    public T mapLine(String line);
}
