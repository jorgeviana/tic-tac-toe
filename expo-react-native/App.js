import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native';
import { useState } from 'react';

export default function App() {
  const [board, setBoard] = useState(
    [
      { position: "NORTH_WEST", player: null },
      { position: "NORTH", player: null },
      { position: "NORTH_EAST", player: null },
      { position: "WEST", player: null },
      { position: "CENTER", player: null },
      { position: "EAST", player: null },
      { position: "SOUTH_WEST", player: null },
      { position: "SOUTH", player: null },
      { position: "SOUTH_EAST", player: null }
    ]
  );

  const handlePress = (index) => {
  }

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Tic Tac Toe</Text>
      <View style={styles.board}>
        {board.map((value, index) => (
          <TouchableOpacity
            testID={value.position}
            key={index}
            style={styles.square}
            onPress={() => handlePress(index)}>
            <Text style={styles.symbol}> ::-:: </Text>
          </TouchableOpacity>
        ))}
      </View>
      <Text testID="status" style={styles.title}>::STATUS::</Text>
     
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#fff',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  board: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    width: 300,
  },
  square: {
    width: 100,
    height: 100,
    backgroundColor: '#ddd',
    justifyContent: 'center',
    alignItems: 'center',
    borderWidth: 1,
    borderColor: '#999',
  },
  symbol: {
    fontSize: 48,
  },
});
