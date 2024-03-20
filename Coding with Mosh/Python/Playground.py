point = {"x": 1, "y": 2}
point = dict(x=1, y=2)

print(point["x"])
point["x"] = 12
point["z"] = 22

print(point)

if "a" in point:
    print(point["a"])

print(point.get("a", 0))  # 0 is the default value if a does not exist

del point["x"]
print(point)

for key in point:
    print(key, point[key])

for key, value in point.items():
    print(key, value)


for x in point.items():
    print(x)
