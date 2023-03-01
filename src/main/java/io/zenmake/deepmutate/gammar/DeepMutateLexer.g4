lexer grammar DeepMutateLexer;

options { caseInsensitive = true; }

//===========KEYWORDS======================================//
FROM            :           'FROM'                          ;
MUTATE          :           'MUTATE'                        ;
MATCH           :           'MATCH'                         ;
WHERE           :           'WHERE'                         ;
SET             :           'SET'                           ;
INSERT          :           'INSERT'                        ;
REPLACE         :           'REPLACE'                       ;
DEFINE          :           'DEF'       | 'DEFINE'          ;
//===========CONFIGURATIONS================================//
TYPE            :           'TYPE'                          ;
ANALYZE         :           'ANALYZE'                       ;
REPORT          :           'REPORT'                        ;
CONSOLE         :           'CONSOLE'                       ;
URI             :           'URI'                           ;
LANG            :           'LANG'      |   'LANGUAGE'      ;
DIR             :           'DIR'       |   'DIRS'          ;
PATH            :           'PATH'      |   'PATHS'         ;
FILE            :           'FILE'      |   'FILES'         ;
CODE            :           'CODE'      |   'CODES'         ;
OUTPUT          :           'OUT'       |   'OUTPUT'        ;
DATASTORE       :           'STORE'     |   'DATASTORE'     ;
DB              :           'DB'        |   'DATABASE'      ;
USER            :           'USER'      |   'USERNAME'      ;
PASS            :           'PASS'      |   'PASSWORD'      ;
ACTIVE          :           'ACTIVE'    |   'IS_ACTIVE'     ;
BUILD           :           'BUILD'     |   'BUILD_SYSTEM'  ;
//===========PUNCTUATIONS==================================//
RIGHT_ARROW     :           '->'                            ;
SEMICOLON       :           ';'                             ;
PIPE            :           '|'                             ;
QM              :           '?'                             ;
COLON           :           ':'                             ;
RANGE           :           '..'                            ;
COMMA           :           ','                             ;
LRB             :           '('                             ;
RRB             :           ')'                             ;
LSB             :           '['                             ;
RSB             :           ']'                             ;
LCB             :           '{'                             ;
RCB             :           '}'                             ;
//===========OPERATORS=====================================//
AND             :           '&&'                            ;
OR              :           '||'                            ;
NOT             :           '!'                             ;
EQ              :           '=='                            ;
NE              :           '!='                            ;
LT              :           '<'                             ;
LTE             :           '<='                            ;
GT              :           '>'                             ;
GTE             :           '>='                            ;
PLUS            :           '+'                             ;
MINUS           :           '-'                             ;
MUL             :           '*'                             ;
DIV             :           '/'                             ;
MOD             :           '%'                             ;
BIT_AND         :           '&'                             ;
SHIFT_LEFT      :           '<<'                            ;
SHIFT_RIGHT     :           '>>'                            ;
ASSIGN          :           '='                             ;
SCOPE           :           '::'                            ;
ACCESS          :           '.'                             ;
REGEX_MATCH     :           '=~'                            ;
REGEX_NON_MATCH :           '!~'                            ;
//==============STRINGS====================================================================================================//
IDENTIFIER                      :   [A-Z_] [A-Z_0-9]*                                                                       ;

TEXT                            :   LETTER+                                                                                 ;

STRING_LITERAL                  :   '\'' (~'\'' | '\'\'')* '\''  {setText(getText().substring(1, getText().length()-1));}   ;
DOUBLE_QUOTED_STRING_LITERAL    :   '"' ~'"'+ '"'                                                                           ;
BACKSTICK_STRING_LITERAL        :   '`' ~'`'+ '`'                                                                           ;

BLOCK_COMMENT                   :   '/*' (BLOCK_COMMENT | .)*? '*/'     -> channel(HIDDEN)                                  ;
LINE_COMMENT                    :   '//' ~[\r\n]*                       -> channel(HIDDEN)                                  ;

WHITE_SPACE                     :   [ \t\r\n]+                          -> channel(HIDDEN)                                  ;
//=============FRAGMENTS===================================================================================================//
fragment HEX_DIGIT              :   [0-9A-F]                                                                                ;
fragment DIGIT                  :   [0-9]                                                                                   ;
fragment LETTER                 :   [a-z]                                                                                   ;
//=========================================================================================================================//
