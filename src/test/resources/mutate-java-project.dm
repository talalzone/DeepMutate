//from (code='class Sample { public void someMethod() { int j = sampleMethodCall(); }}')
//from(file=['deepmutate-sample-java-project/src/java/mainSampleClass.java']
//from(console)
from(dir=['/Users/talal/Development/deepmutate-sample-java-project'], build='gradle')
mutate(lang='java', type='semantic', analyze='true')
out(store='mongodb', report='html')  //report=['console', 'csv', 'html', 'true'] //db=['mongodb', 'arangodb', 'cache', 'memory', 'csv'] //schema='mongodb://..'
{

    def methodCallMutators {

        [method_call_returns_int][active='true']
        match:  'int i = someNonVoidMethod();'
        set:    'int i = 0;'

        [method_call_returns_obj][active='false']
        match:  'Object o = someNonVoidMethod();'
        set:    'Object o = null;'

    }

    def untestedMutators {

        [active='false']
        match:  'if (a == b)'
        set:    'if (true)'

        [const_mutator][active='false']
        match:  'int |i| = 40'
        set:    'int i = |i| + 1'

        [active='false']
        match:  'if (a <= b)'
        set:    'if (a < b)'

        [active='false']
        match ('if (a >= b)')
        set ('if (a > b)')

        [active='false']
        match ('if (a == b)')
        set ('if (a != b)')

        [active='false']
        match ('i++')
        set ('i--')

        [active='false']
        match ('return i')
        set ('return [+|-]i')

        [active='false']
        match ('int a = b + c')
        set ('int a = b - c')

        [active='false']
        match ('someVoidMethodCall()')
        set ('NO_OP')

        [active='false']
        match ('return x')
        where ('x is java.util.Optional')
        set ('return Optional.empty()')

        [active='false']
        match ('return x')
        where ('x is java.util.List')
        set ('return Collections.emptyList()')

   }

}