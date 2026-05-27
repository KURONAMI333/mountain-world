# Mountain World

> Overworld becomes all mountain, all the time. Y 80-300 is playable, valleys cut down past Y 0 into chasms, peaks reach glacier biome at Y 280+. Vertical traversal is the game.

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![NeoForge 1.21.1](https://img.shields.io/badge/NeoForge-1.21.1-orange.svg)](https://neoforged.net)
[![Depends on Isekai API](https://img.shields.io/badge/Depends-Isekai%20API-9333ea)](https://github.com/KURONAMI333/isekai-api)

---

## Concept

The entire overworld becomes vertical. There is no plain, no flat coast, no horizontal expanse — only slope, valley, and peak. Vanilla ores, structures, and mobs are remapped via Isekai API: villages sit in valleys, strongholds in the deepest chasms, glaciers cap the highest peaks.

Pairs naturally with bridge / rope / climbing / glider mods.

## How it works

Mountain World is built on **[Isekai API](https://github.com/KURONAMI333/isekai-api)**, a neutral universal worldgen library.

The library provides composable density and rule-adaptation primitives; Mountain World composes them to express the tall-mountain worldshape. The library has no concept of "mountain" — Mountain World is just one application of `add`, `lerp`, `mask_y_range`, and friends.

## Status

**v0.1**: skeleton. `WorldshapeDescriptor` declaration + density composition land with Isekai API v0.2.

## Dependencies

- NeoForge 1.21.1
- [Isekai API](https://github.com/KURONAMI333/isekai-api) (required)

## License

[MIT License](LICENSE) — modpack inclusion welcome, no credit required.

## Credits

- Author: KURONAMI
