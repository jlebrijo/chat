Functional specs:
-------------------
Speaker login:
	* should choose a room (Sports, Houses, Cars) or add a new one (distinct names)
	* use a nick (not used in the room)
The rooms:
	* should have N speakers
The Speaker in the room can:
	* Add comments in the board of a room, with the pattern: nick> "comments"
	* Read comments of other users, only the last 10 comments is enough
	* Can leave the room when he wants
Every 30 minutes inactive rooms are removed

Proccess
----------
1. TDD --> Emerging the design
2. Annotating with JSF2