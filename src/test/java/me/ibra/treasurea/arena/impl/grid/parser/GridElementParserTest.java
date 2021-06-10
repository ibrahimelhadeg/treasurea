package me.ibra.treasurea.arena.impl.grid.parser;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridElementParserTest {

    @Test
    void should_not_parse_invalid_element() {
        ParsedGridElement element = GridElementParser.parseGridElement("P-1-1");

        assertNull(element);
    }

    @Test
    void should_parse_mountain_element() {
        ParsedGridElement element = GridElementParser.parseGridElement("M-1-1");

        assertEquals('M', element.type());
        assertEquals(0, element.width());
        assertEquals(0, element.height());
        assertEquals(1, element.x());
        assertEquals(1, element.y());
        assertEquals('\u0000', element.orientation());
        assertEquals(0, element.occurrences());
        assertNull(element.name());
        assertNull(element.moves());
    }

    @Test
    void should_parse_treasure_element() {
        ParsedGridElement element = GridElementParser.parseGridElement("T-0-3-2");

        assertEquals('T', element.type());
        assertEquals(0, element.width());
        assertEquals(0, element.height());
        assertEquals(0, element.x());
        assertEquals(3, element.y());
        assertEquals('\u0000', element.orientation());
        assertEquals(2, element.occurrences());
        assertNull(element.name());
        assertNull(element.moves());
    }

    @Test
    void should_parse_explorer_element() {
        ParsedGridElement element = GridElementParser.parseGridElement("A-Indiana-1-1-S-AADADA");

        assertEquals('A', element.type());
        assertEquals(0, element.width());
        assertEquals(0, element.height());
        assertEquals(1, element.x());
        assertEquals(1, element.y());
        assertEquals('S', element.orientation());
        assertEquals(0, element.occurrences());
        assertEquals("Indiana", element.name());
        assertEquals("AADADA", element.moves());
    }

    @Test
    void should_parse_empty_grid_element() {
        ParsedGridElement element = GridElementParser.parseSimpleGrid("C-3-4");

        assertEquals('C', element.type());
        assertEquals(3, element.width());
        assertEquals(4, element.height());
        assertEquals(0, element.x());
        assertEquals(0, element.y());
        assertEquals('\u0000', element.orientation());
        assertEquals(0, element.occurrences());
        assertNull(element.name());
        assertNull(element.moves());
    }

    @Test
    void should_parse_populated_grid_element() {
        String inputFilledGrid = """
                    C-3-4
                    M-1-0
                    M-2-1
                    T-0-3-2
                    T-1-3-3
                    A-Lara-1-1-S-AADADAGGA
                    """;
        List<ParsedGridElement> elements = GridElementParser.parsePopulatedGrid(inputFilledGrid);

        assertEquals('C', elements.get(0).type());
        assertEquals(3, elements.get(0).width());
        assertEquals(4, elements.get(0).height());
        assertEquals(0, elements.get(0).x());
        assertEquals(0, elements.get(0).y());
        assertEquals('\u0000', elements.get(0).orientation());
        assertEquals(0, elements.get(0).occurrences());
        assertNull(elements.get(0).name());
        assertNull(elements.get(0).moves());

        assertEquals('M', elements.get(1).type());
        assertEquals(0, elements.get(1).width());
        assertEquals(0, elements.get(1).height());
        assertEquals(1, elements.get(1).x());
        assertEquals(0, elements.get(1).y());
        assertEquals('\u0000', elements.get(1).orientation());
        assertEquals(0, elements.get(1).occurrences());
        assertNull(elements.get(1).name());
        assertNull(elements.get(1).moves());

        assertEquals('M', elements.get(2).type());
        assertEquals(0, elements.get(2).width());
        assertEquals(0, elements.get(2).height());
        assertEquals(2, elements.get(2).x());
        assertEquals(1, elements.get(2).y());
        assertEquals('\u0000', elements.get(2).orientation());
        assertEquals(0, elements.get(2).occurrences());
        assertNull(elements.get(2).name());
        assertNull(elements.get(2).moves());

        assertEquals('T', elements.get(3).type());
        assertEquals(0, elements.get(3).width());
        assertEquals(0, elements.get(3).height());
        assertEquals(0, elements.get(3).x());
        assertEquals(3, elements.get(3).y());
        assertEquals('\u0000', elements.get(3).orientation());
        assertEquals(2, elements.get(3).occurrences());
        assertNull(elements.get(3).name());
        assertNull(elements.get(3).moves());

        assertEquals('T', elements.get(4).type());
        assertEquals(0, elements.get(4).width());
        assertEquals(0, elements.get(4).height());
        assertEquals(1, elements.get(4).x());
        assertEquals(3, elements.get(4).y());
        assertEquals('\u0000', elements.get(4).orientation());
        assertEquals(3, elements.get(4).occurrences());
        assertNull(elements.get(4).name());
        assertNull(elements.get(4).moves());

        assertEquals('A', elements.get(5).type());
        assertEquals(0, elements.get(5).width());
        assertEquals(0, elements.get(5).height());
        assertEquals(1, elements.get(5).x());
        assertEquals(1, elements.get(5).y());
        assertEquals('S', elements.get(5).orientation());
        assertEquals(0, elements.get(5).occurrences());
        assertEquals("Lara", elements.get(5).name());
        assertEquals("AADADAGGA", elements.get(5).moves());
    }
}
