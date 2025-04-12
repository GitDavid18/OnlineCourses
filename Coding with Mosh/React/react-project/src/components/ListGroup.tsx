import { useState } from "react";

function ListGroup() {
  let items = ["Duesseldorf", "Berlin", "Munchen", "Hamburg"];

  const [selectedItem, setSelectedItem] = useState(-1);

  //   const items = [];

  const message = items.length === 0 && <p>No items found</p>;
  return (
    <>
      <h1>List</h1>
      {message}
      <ul className="list-group">
        {items.map((item, index) => (
          <li
            className={
              selectedItem === index
                ? "list-group-item active"
                : "list-group-item"
            }
            key={item}
            onClick={() => {
              setSelectedItem(index);
            }}
          >
            {item}
          </li>
        ))}
      </ul>
    </>
  );
}

export default ListGroup;
