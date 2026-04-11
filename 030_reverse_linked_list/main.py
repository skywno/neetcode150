# Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.

from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
            
        prev = None
        curr = head
        while curr:
            next = curr.next
            curr.next = prev
            if next is None:
                break
            prev = curr
            curr = next
        return curr


