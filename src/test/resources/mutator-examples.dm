from (dir=['deepmutate'])
mutate (lang='java', type='semantic', analyze='true')
out (store='mongodb', report='true'){

   def mutators {

        [method_call_mutator][active=true]
        match:  'int i = someNonVoidMethod()'
        set:    'int i = 0'

        [active='false']
        match:  'Object o = someNonVoidMethod()'
        set:    'Object o = null'

        match:  'if (a == b)'
        set:    'if (true)'

        [const_mutator]
        match:  'int |i| = 40'
        set:    'int i = |i| + 1'

        match:  'if (a <= b)'
        set:    'if (a < b)'

        match ('if (a >= b)')
        set ('if (a > b)')

        match ('if (a == b)')
        set ('if (a != b)')

        match ('i++')
        set ('i--')

        match ('return i')
        set ('return [+|-]i')

        match ('int a = b + c')
        set ('int a = b - c')

        match ('someVoidMethodCall()')
        set ('NO_OP')

        match ('return x')
        where ('x is java.util.Optional')
        set ('return Optional.empty()')

        match ('return x')
        where ('x is java.util.List')
        set ('return Collections.emptyList()')
   }
}