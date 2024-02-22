class Solution:
    def isValid(self, s: str) -> bool:
        totle = []
        for a in s:
            if len(totle) == 0:
                totle.append(a)
                continue
            if a == ')':
                if totle.pop() == '(':
                    continue
                else:
                    return False
            if a == ']':
                if totle.pop() == '[':
                    continue
                else:
                    return False
            if a == '}':
                if totle.pop() == '{':
                    continue
                else:
                    return False
            totle.append(a)

        if len(totle) == 0:
            return True
        else:
            return False


print(Solution.isValid(None, '()'))
