
class MinStack:

    def __init__(self):
        self._min_stack = []
        self._stack = []

    def push(self, val: int) -> None:
        self._stack.append(val)
        val = min(val, self._min_stack[-1] if self._min_stack else val)
        self._min_stack.append(val)

    def pop(self) -> None:
        self._min_stack.pop()
        self._stack.pop()

    def top(self) -> int:
        return self._stack[-1]

    def getMin(self) -> int:
        return  self._min_stack[-1]

