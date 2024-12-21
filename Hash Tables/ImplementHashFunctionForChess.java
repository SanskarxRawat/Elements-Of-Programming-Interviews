import java.util.Random;

public class ImplementHashFunctionForChess {

    public class ChessHash {
        private static final int BOARD_SIZE = 64; // 8x8 chessboard
        private static final int PIECE_TYPES = 12; // 6 piece types * 2 colors
        private static final int AUX_KEYS = 5; // Castling, en passant, turn

        private long[][] zobristTable; // Random keys for pieces on squares
        private long[] auxKeys; // Keys for auxiliary information
        private long currentHash; // Current hash of the board state

        public ChessHash() {
            zobristTable = new long[PIECE_TYPES][BOARD_SIZE];
            auxKeys = new long[AUX_KEYS];
            initializeZobristTable();
            currentHash = 0; // Initial hash will be computed for the starting board
        }

        // Initialize the Zobrist table with random values
        private void initializeZobristTable() {
            Random random = new Random(42); // Seed for reproducibility
            for (int i = 0; i < PIECE_TYPES; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    zobristTable[i][j] = random.nextLong();
                }
            }
            for (int i = 0; i < AUX_KEYS; i++) {
                auxKeys[i] = random.nextLong();
            }
        }

        // Compute the initial hash from a given board state
        public long computeInitialHash(char[][] board, boolean whiteToMove, boolean[] castlingRights, int enPassantSquare) {
            currentHash = 0;

            // XOR pieces on the board
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    char piece = board[row][col];
                    if (piece != '.') {
                        int pieceIndex = pieceToIndex(piece);
                        int squareIndex = row * 8 + col;
                        currentHash ^= zobristTable[pieceIndex][squareIndex];
                    }
                }
            }

            // XOR turn
            if (whiteToMove) {
                currentHash ^= auxKeys[0];
            }

            // XOR castling rights
            for (int i = 0; i < 4; i++) {
                if (castlingRights[i]) {
                    currentHash ^= auxKeys[1 + i];
                }
            }

            // XOR en passant square (if applicable)
            if (enPassantSquare >= 0) {
                currentHash ^= auxKeys[4] ^ zobristTable[0][enPassantSquare];
            }

            return currentHash;
        }

        // Update the hash based on the move
        public long updateHash(int fromSquare, int toSquare, char movedPiece, char capturedPiece,
                               boolean whiteToMove, boolean[] castlingRights, int enPassantSquare) {

            int movedPieceIndex = pieceToIndex(movedPiece);
            currentHash ^= zobristTable[movedPieceIndex][fromSquare]; // Remove piece from old square
            currentHash ^= zobristTable[movedPieceIndex][toSquare]; // Add piece to new square

            if (capturedPiece != '.') {
                int capturedPieceIndex = pieceToIndex(capturedPiece);
                currentHash ^= zobristTable[capturedPieceIndex][toSquare]; // Remove captured piece
            }

            // Update turn
            currentHash ^= auxKeys[0];

            // Update castling rights and en passant (if necessary)
            // Assume functions to compute updated rights and en passant square are available

            return currentHash;
        }

        // Map a piece to its index in the Zobrist table
        private int pieceToIndex(char piece) {
            switch (piece) {
                case 'P': return 0; // White Pawn
                case 'N': return 1; // White Knight
                case 'B': return 2; // White Bishop
                case 'R': return 3; // White Rook
                case 'Q': return 4; // White Queen
                case 'K': return 5; // White King
                case 'p': return 6; // Black Pawn
                case 'n': return 7; // Black Knight
                case 'b': return 8; // Black Bishop
                case 'r': return 9; // Black Rook
                case 'q': return 10; // Black Queen
                case 'k': return 11; // Black King
                default: throw new IllegalArgumentException("Invalid piece: " + piece);
            }
        }

        public long getCurrentHash() {
            return currentHash;
        }
    }

}
