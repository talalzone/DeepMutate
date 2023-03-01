db: 'arangodb://....'

from deepmutate
mutate (java) {

    def relationalOpMutator {
        match (conditional_type)
        replace [== -> !=, >= -> <=]
    }

    def conditionalOpMutator {
        match (conditional_type)
        replace [|| -> &&, | -> &]
    }

    def arithmeticOpMutator {
        match ([+, -, /, *]: BINARY_OP)
        set [+ <=> -, / <=> *]
    }

    def shiftOpMutator {
        match ([>>, <<]: BINARY_OP)
        set (>> <=> <<)
    }

    def unaryOpMutator {
        match ([-, +]: UNARY_OP)
        set (- <=> +)
    }

    def literalMutator {
        match (x: LITERAL) {
            case 'number' => set [0, 1, -1]
            case 'bool'   => set [true <=> false]
            case 'str'    => set ['']
        }
    }

    def conditionalMutator {
        match (if: KEYWORD, x: IDENTIFIER, eq: EQUALITY_OP, y: IDENTIFIER)
        set   (if: KEYWORD, true: LITERAL)
    }

    def exprValueMutator {
        match (return: KEYWORD, x: IDENTIFIER)
        set (return: KEYWORD, 0: LITERAL)

        match (int: KEYWORD, x: IDENTIFIER, =: ASSIGNMENT_OP, y: IDENTIFIER)
        set (int: KEYWORD, x: IDENTIFIER, =: ASSIGNMENT_OP, 0: INT_LITERAL)

        match (int: KEYWORD, x: IDENTIFIER, =: ASSIGNMENT_OP, y: METHOD_CALL)
        set (int: KEYWORD, x: IDENTIFIER, =: ASSIGNMENT_OP, 0: INT_LITERAL)
    }

    def constMutator {
        match (int: KEYWORD, x: IDENTIFIER, =: ASSIGNMENT_OP, y: LITERAL)
        set (int: KEYWORD, x: IDENTIFIER, =: ASSIGNMENT_OP, y=y+1: LITERAL)
    }

    def returnStatementMutator {
        match (return: KEYWORD, x: java.util.Optional)
        set (return: KEYWORD, x: Optional.empty())

        match (return: KEYWORD, x: java.lang.String)
        set (return: KEYWORD, x: '')

        match (return: KEYWORD, x: java.lang.String)
        set (return: KEYWORD, x: '')

        match (return: KEYWORD, x: java.util.List)
        set (return: KEYWORD, x: Collections.emptyList())

        match (return: KEYWORD, x: java.util.Collection)
        set (return: KEYWORD, x: Collections.emptyList())

        match (return: KEYWORD, x: java.util.Set)
        set (return: KEYWORD, x: Collections.emptyList())

        match (return: KEYWORD, x: java.lang.Character)
        set (return: KEYWORD, 0: LITERAL)
    }

    def statementDeletionMutator {
        match (method_call)
        set (NO_OP)

        match (return: KEYWORD, x: IDENTIFIER)
        set (NO_OP)

        match (break: KEYWORD)
        set (NO_OP)

        (continue: KEYWORD) => (NO_OP)

        (x: IDENTIFIER, =: EQ_OPERATOR, y: IDENTIFIER) => (NO_OP)

        (++: INC_OPERATOR, x: IDENTIFIER) => (NO_OP)
        (--: DEC_OPERATOR, x: IDENTIFIER) => (NO_OP)

        (x: IDENTIFIER, ++: INC_OPERATOR) => (NO_OP)
        (x: IDENTIFIER, --: DEC_OPERATOR) => (NO_OP)
    }

   def cleanMutator* {

        match (int |i| = 40)
        set (int i = |i| + 1)

        match (int i = someNonVoidMethod())
        set (int i = 0)

        match (Object o = someNonVoidMethod()|)
        set (Object o = null)

        match (if (a == b))
        set (if (true))

        match (if (a <= b))
        set (if (a < b))

        match (if (a >= b))
        set (if (a > b))

        match (if (a == b) )
        set (if (a != b) )

        match (i++)
        set (i--)

        match (return i)
        set (return [+|-]i)

        match (int a = b + c)
        set (int a = b - c)

        match (someVoidMethodCall();)
        set (NO_OP)

        match (return x)
        where (x is java.util.Optional)
        set (return Optional.empty())

        match (return x)
        where (x is java.util.List)
        set (return Collections.emptyList())

   }
}