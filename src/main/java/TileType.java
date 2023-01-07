import java.awt.*;

public enum TileType {

    TypeI(new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MAX), 4, 4, 1, new boolean[][] {
            {
                    false, false, false, false,
                    true, true, true, true,
                    false, false, false, false,
                    false, false, false, false,
            },
            {
                    false, false, true, false,
                    false, false, true, false,
                    false, false, true, false,
                    false, false, true, false,
            },
            {
                    false, false, false, false,
                    false, false, false, false,
                    true, true, true, true,
                    false, false, false, false,
            },
            {
                    false, true, false, false,
                    false, true, false, false,
                    false, true, false, false,
                    false, true, false, false,
            }
    }),

    TypeJ(new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX), 3, 3, 2, new boolean[][] {
            {
                    true, false, false,
                    true, true, true,
                    false, false, false,
            },
            {
                    false, true, true,
                    false, true, false,
                    false, true, false,
            },
            {
                    false, false, false,
                    true, true, true,
                    false, false, true,
            },
            {
                    false, true, false,
                    false, true, false,
                    true, true, false,
            }
    }),

    TypeL(new Color(BoardPanel.COLOR_MAX, 127, BoardPanel.COLOR_MIN), 3, 3, 2, new boolean[][] {
            {
                    false, false, true,
                    true, true, true,
                    false, false, false,
            },
            {
                    false, true, false,
                    false, true, false,
                    false, true, true,
            },
            {
                    false, false, false,
                    true, true, true,
                    true, false, false,
            },
            {
                    true, true, false,
                    false, true, false,
                    false, true, false,
            }
    }),

    TypeO(new Color(BoardPanel.COLOR_MAX, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN), 2, 2, 2, new boolean[][] {
            {
                    true, true,
                    true, true,
            },
            {
                    true, true,
                    true, true,
            },
            {
                    true, true,
                    true, true,
            },
            {
                    true, true,
                    true, true,
            }
    }),

    TypeS(new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN), 3, 3, 2, new boolean[][] {
            {
                    false, true, true,
                    true, true, false,
                    false, false, false,
            },
            {
                    false, true, false,
                    false, true, true,
                    false, false, true,
            },
            {
                    false, false, false,
                    false, true, true,
                    true, true, false,
            },
            {
                    true, false, false,
                    true, true, false,
                    false, true, false,
            }
    }),

    TypeT(new Color(128, BoardPanel.COLOR_MIN, 128), 3, 3, 2, new boolean[][] {
            {
                    false, true, false,
                    true, true, true,
                    false, false, false,
            },
            {
                    false, true, false,
                    false, true, true,
                    false, true, false,
            },
            {
                    false, false, false,
                    true, true, true,
                    false, true, false,
            },
            {
                    false, true, false,
                    true, true, false,
                    false, true, false,
            }
    }),

    TypeZ(new Color(BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN, BoardPanel.COLOR_MIN), 3, 3, 2, new boolean[][] {
            {
                    true, true, false,
                    false, true, true,
                    false, false, false,
            },
            {
                    false, false, true,
                    false, true, true,
                    false, true, false,
            },
            {
                    false, false, false,
                    true, true, false,
                    false, true, true,
            },
            {
                    false, true, false,
                    true, true, false,
                    true, false, false,
            }
    });

    private final Color baseColor;

    private final Color lightColor;

    private final Color darkColor;

    private final int spawnCol;

    private final int spawnRow;

    private final int dimension;

    private final int rows;

    private final int cols;

    private final boolean[][] tiles;

    TileType(final Color color, final int dimension, final int cols, final int rows, final boolean[][] tiles) {
        this.baseColor = color;
        this.lightColor = color.brighter();
        this.darkColor = color.darker();
        this.dimension = dimension;
        this.tiles = tiles;
        this.cols = cols;
        this.rows = rows;
        this.spawnCol = 5 - (dimension >> 1);
        this.spawnRow = getTopInset(0);
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public int getDimension() {
        return dimension;
    }

    public int getSpawnColumn() {
        return spawnCol;
    }

    public int getSpawnRow() {
        return spawnRow;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isTile(final int x, final int y, final int rotation) {
        return tiles[rotation][y * dimension + x];
    }

    public int getLeftInset(final int rotation) {
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                if (isTile(x, y, rotation)) {
                    return x;
                }
            }
        }
        return -1;
    }

    public int getRightInset(final int rotation) {

        for (int x = dimension - 1; x >= 0; x--) {
            for (int y = 0; y < dimension; y++) {
                if (isTile(x, y, rotation)) {
                    return dimension - x;
                }
            }
        }
        return -1;
    }

    public int getTopInset(final int rotation) {
        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                if (isTile(x, y, rotation)) {
                    return y;
                }
            }
        }
        return -1;
    }

    public int getBottomInset(final int rotation) {
        for (int y = dimension - 1; y >= 0; y--) {
            for (int x = 0; x < dimension; x++) {
                if (isTile(x, y, rotation)) {
                    return dimension - y;
                }
            }
        }
        return -1;
    }
}
