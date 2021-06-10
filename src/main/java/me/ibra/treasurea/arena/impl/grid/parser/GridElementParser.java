package me.ibra.treasurea.arena.impl.grid.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GridElementParser {

    public static final String ATTRIBUTES_SEPARATOR = "-";

    public static ParsedGridElement parseSimpleGrid(String arenaStr) {
        String[] gridProps = arenaStr.split(ATTRIBUTES_SEPARATOR);

        return new ParsedGridElement.Builder()
                .type(gridProps[0].charAt(0))
                .width(Integer.parseInt(gridProps[1]))
                .height(Integer.parseInt(gridProps[2]))
                .build();
    }

    public static List<ParsedGridElement> parsePopulatedGrid(String inputFilledGrid) {
        String[] gridInputLines = inputFilledGrid.split("\\r?\\n");

        return Arrays.stream(gridInputLines)
                .map(GridElementParser::parseGridElement)
                .collect(Collectors.toList());
    }

    public static ParsedGridElement parseGridElement(String elmStr) {
        return switch (elmStr.charAt(0)) {
            case 'C' -> parseSimpleGrid(elmStr);
            case 'M' -> parseMountain(elmStr);
            case 'T' -> parseTreasure(elmStr);
            case 'A' -> parseExplorer(elmStr);
            default -> null;
        };
    }

    private static ParsedGridElement parseMountain(String mountainStr) {
        String[] mountainProps = mountainStr.split(ATTRIBUTES_SEPARATOR);

        return new ParsedGridElement.Builder()
                .type(mountainProps[0].charAt(0))
                .x(Integer.parseInt(mountainProps[1]))
                .y(Integer.parseInt(mountainProps[2]))
                .build();
    }

    private static ParsedGridElement parseTreasure(String treasureStr) {
        String[] treasureProps = treasureStr.split(ATTRIBUTES_SEPARATOR);

        return new ParsedGridElement.Builder()
                .type(treasureProps[0].charAt(0))
                .x(Integer.parseInt(treasureProps[1]))
                .y(Integer.parseInt(treasureProps[2]))
                .occurrences(Integer.parseInt(treasureProps[3]))
                .build();
    }

    private static ParsedGridElement parseExplorer(String explorerStr) {
        String[] explorerProps = explorerStr.split(ATTRIBUTES_SEPARATOR);

        return new ParsedGridElement.Builder()
                .type(explorerProps[0].charAt(0))
                .name(explorerProps[1])
                .x(Integer.parseInt(explorerProps[2]))
                .y(Integer.parseInt(explorerProps[3]))
                .orientation(explorerProps[4].charAt(0))
                .moves(explorerProps[5])
                .build();
    }
}
