package kk.lichess.bot;

import kk.chessbot.Piece;
import kk.chessbot.wrappers.Move;
import org.junit.jupiter.api.Test;

import static kk.chessbot.moves.BoardUtils.board;
import static kk.chessbot.wrappers.Position.position;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveUtilsTest {
    @Test
    void test_move_conversion() {
        assertEquals("a2b3", MoveUtils.lichesMove(Move.from("a2xb3")));
        assertEquals("c1c2", MoveUtils.lichesMove(Move.from("Rc1xc2")));

        assertEquals("c5d6", MoveUtils.lichesMove(Move.from("c5xd6e.p.")));

        assertEquals("c5xd6",
                MoveUtils.fromLichess("c5d6",
                        board()
                                .with(Piece.Pawn, false, position("c5"))
                                .with(Piece.Rook, true, position("d6"))
                                .build()).toString());

        assertEquals("c5xd6e.p.",
                MoveUtils.fromLichess("c5d6",
                        board()
                                .with(Piece.Pawn, false, position("c5"))
                                .with(Piece.Pawn, true, position("d5"))
                                .build()).toString());

        assertEquals("Rc1xc2",
                MoveUtils.fromLichess("c1c2",
                        board()
                                .with(Piece.Pawn, false, position("c2"))
                                .with(Piece.Rook, true, position("c1"))
                                .build()).toString());

        assertEquals("a2xb3",
                MoveUtils.fromLichess("a2b3",
                        board()
                                .with(Piece.Pawn, true, position("a2"))
                                .with(Piece.Queen, false, position("b3"))
                                .build()).toString());

    }
}