
class MinStack:

    def __init__(self):
        self._min_idx = None
        self._min_idx_stack = []
        self._stack = []

    def push(self, val: int) -> None:
        self._stack.append(val)
        if self._min_idx is None or self._stack[self._min_idx] > val:
            # the latest element added is the minimum value.
            self._min_idx = len(self._stack) - 1
            self._min_idx_stack.append(self._min_idx)
        else:
            self._min_idx_stack.append(self._min_idx)
        print(f"min indx: {self._min_idx}")

    def pop(self) -> None:
        if self._stack:
            self._min_idx_stack.pop()
            self._stack.pop()

            if self._min_idx_stack:
                self._min_idx = self._min_idx_stack[-1]
            else:
                self._min_idx = None

    def top(self) -> int:
        if self._stack:
            return self._stack[-1]

    def getMin(self) -> int:
        print(f"{len(self._stack)} length, but, idx is {self._min_idx}")
        if self._stack:
            return  self._stack[self._min_idx]

