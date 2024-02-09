import { render, fireEvent } from '@testing-library/react-native';
import App from "./App";

describe("App", () => {
  xit("X wins", () => {
    const app =  render(<App />);
    app.getByText("X plays!");

    fireEvent.press(app.getByTestId("NORTH_WEST"));
    fireEvent.press(app.getByTestId("WEST"));

    fireEvent.press(app.getByTestId("NORTH"));
    fireEvent.press(app.getByTestId("CENTER"));

    fireEvent.press(app.getByTestId("NORTH_EAST"));

    app.getByText("X wins!")
  });
});
